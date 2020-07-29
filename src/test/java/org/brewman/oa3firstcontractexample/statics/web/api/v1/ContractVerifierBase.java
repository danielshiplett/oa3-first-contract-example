package org.brewman.oa3firstcontractexample.statics.web.api.v1;

import com.google.common.collect.ImmutableList;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.brewman.oa3firstcontractexample.statics.service.StaticsService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.BDDMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ContractVerifierBase {

    private static final Logger LOG = LoggerFactory.getLogger(ContractVerifierBase.class);

    @BeforeEach
    public void setup() {
        LOG.debug("setup: ");

        List<String> mockContent = ImmutableList.of("this", "and", "that");
        Page<String> page = new PageImpl<>(mockContent, Pageable.unpaged(), mockContent.size());

        StaticsService staticsService = BDDMockito.mock(StaticsService.class);
        BDDMockito.willReturn(page).given(staticsService).actualGetLists(BDDMockito.any());

        RestAssuredMockMvc.standaloneSetup(new ListsApiController(new ListsApiDelegateImpl(staticsService)));
    }
}
