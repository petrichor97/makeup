package com.tianxuan.makeup;

import com.tianxuan.makeup.entity.ChargeMoney;
import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.entity.UserWelfare;
import com.tianxuan.makeup.enums.ResultEnum;
import com.tianxuan.makeup.excpetion.SellException;
import com.tianxuan.makeup.repository.OrderMoneyRepository;
import com.tianxuan.makeup.repository.TxVipUserRepository;
import com.tianxuan.makeup.utils.KeyUtil;
import com.tianxuan.makeup.utils.Validator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
public class MakeupApplicationTests {

@Test
    public void test() {
    boolean b = Validator.idPasswordValidator("123456");
    System.out.println(b);
}


}
