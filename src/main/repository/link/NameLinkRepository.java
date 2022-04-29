package main.repository.link;

import main.model.section.experience.NameLink;

public interface NameLinkRepository {

    Long addNameLink(NameLink nameLink);

    NameLink getName(Long id);
}
