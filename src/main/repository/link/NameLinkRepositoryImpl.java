package main.repository.link;

import main.model.section.experience.NameLink;

import java.util.HashMap;
import java.util.Map;

public class NameLinkRepositoryImpl implements NameLinkRepository {

    private Map<Long, NameLink> storage = new HashMap<>();
    private Long size = 0L;

    @Override
    public NameLink save(NameLink nameLink) {
        if (storage.containsValue(nameLink)) {
            return storage.get(getKay(nameLink));
        }
        return storage.put(size++, nameLink);
    }

    private Long getKay(NameLink nameLink) {
        for (Map.Entry<Long, NameLink> map : storage.entrySet()) {
            if (map.getValue().equals(nameLink)) {
                return map.getKey();
            }
        }
        return null;
    }

    @Override
    public NameLink getNameLink(Long id) {
        return storage.get(id);
    }
}
