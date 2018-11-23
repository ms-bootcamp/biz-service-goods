package com.thoughtworks.mstorderservice.contract;

import com.thoughtworks.mstorderservice.MstGoodsServiceApplication;
import com.thoughtworks.mstorderservice.api.GoodsController;
import com.thoughtworks.mstorderservice.dto.GoodsDTO;
import com.thoughtworks.mstorderservice.service.GoodsService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MstGoodsServiceApplication.class)
@ActiveProfiles("test")
public class ContractVerifierBase {

    @Autowired
    private GoodsController goodsController;

    @MockBean
    private GoodsService goodsService;

    @Before
    public void setup() throws Exception {
        RestAssuredMockMvc.standaloneSetup(goodsController);
        GoodsDTO goodsDTO1 = GoodsDTO.builder().id(1).name("iPhone SE2").price(2095).build();
        GoodsDTO goodsDTO2 = GoodsDTO.builder().id(2).name("iPhone X").price(5095).build();
        Mockito.when(goodsService.getGoods()).thenReturn(Arrays.asList(goodsDTO1, goodsDTO2));
    }
}