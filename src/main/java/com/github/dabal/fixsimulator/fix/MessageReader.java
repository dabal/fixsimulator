package com.github.dabal.fixsimulator.fix;

import org.springframework.stereotype.Service;
import quickfix.*;

import java.util.*;

@Service
public class MessageReader {

    public Map<String, Object> readIntoMap(final Message message) {
        Map<String, Object> map = null;
        try {
            map = convertMessage(message.getHeader());
            map.putAll(convertMessage((FieldMap) message));
            map.putAll(convertMessage(message.getTrailer()));
        } catch (final FieldNotFound fieldNotFoundException) {
            throw new RuntimeException();
        }
        return map;
    }

    @SuppressWarnings("rawtypes")
    private Map<String, Object> convertMessage(final FieldMap fieldMap) throws FieldNotFound {
        final Map<String, Object> map = new HashMap<>();
        final Iterator fieldIterator = fieldMap.iterator();
        while (fieldIterator.hasNext()) {
            final Field field = (Field) fieldIterator.next();
            // tu nadmiarowo wrzucamy tag grupy, ktory potem nadpisujemy
            map.put(String.valueOf(field.getTag()), fieldMap.getString(field.getTag()));
        }
        final Iterator<Integer> groupsKeys = fieldMap.groupKeyIterator();
        while (groupsKeys.hasNext()) {
            final List<Object> groupElements = new ArrayList<>();
            final int groupCountTag = groupsKeys.next();
            for (final Group g : fieldMap.getGroups(groupCountTag)) {
                groupElements.add(convertMessage(g));
            }
            map.put(String.valueOf(groupCountTag), groupElements);
        }
        return map;
    }

}
