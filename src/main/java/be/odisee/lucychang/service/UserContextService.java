package be.odisee.lucychang.service;

import be.odisee.lucychang.domain.Persoon;

public interface UserContextService {

    public Persoon getAuthenticatedPersoon();
}
