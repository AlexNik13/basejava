package main.repository.link;

import main.model.section.experience.NameLink;

public interface NameLinkRepository {

    NameLink save(NameLink nameLink);

    NameLink getNameLink(Long id);
}
