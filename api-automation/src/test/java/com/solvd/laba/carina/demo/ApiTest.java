package com.solvd.laba.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.solvd.laba.carina.demo.api.GetAlbumMethods;
import com.solvd.laba.carina.demo.api.GetUserMethods;
import com.solvd.laba.carina.demo.api.PostUserMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ApiTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiTest.class);


    @Test()
    @MethodOwner(owner = "agomez")
    public void testGetAlbums() {
        GetAlbumMethods getAlbumMethods = new GetAlbumMethods();
        getAlbumMethods.callAPIExpectSuccess();
        getAlbumMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAlbumMethods.validateResponseAgainstSchema("api/albums/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

}
