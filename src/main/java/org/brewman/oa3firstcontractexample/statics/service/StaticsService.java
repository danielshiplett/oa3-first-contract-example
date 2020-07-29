package org.brewman.oa3firstcontractexample.statics.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaticsService {

    private static final Logger LOG = LoggerFactory.getLogger(StaticsService.class);

    private List<String> lists = Lists.newArrayList("cities", "states", "countries");

    public Page<String> actualGetLists(Pageable pageable) {
        return new PageImpl<>(lists, pageable, lists.size());
    }
}
