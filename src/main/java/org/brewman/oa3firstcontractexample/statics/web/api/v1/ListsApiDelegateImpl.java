package org.brewman.oa3firstcontractexample.statics.web.api.v1;

import org.brewman.oa3firstcontractexample.statics.service.StaticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ListsApiDelegateImpl implements ListsApiDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ListsApiDelegateImpl.class);

    private final StaticsService staticsService;

    public ListsApiDelegateImpl(StaticsService staticsService) {
        this.staticsService = staticsService;
    }

    @Override
    public ResponseEntity<Page> getAllLists(Pageable pageable) {
        LOG.debug("getAllLists:");

        return ResponseEntity.ok(staticsService.actualGetLists(pageable));
    }
}
