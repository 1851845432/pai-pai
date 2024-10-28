package com.caijiale.paipai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.caijiale.paipai.base.page.PageRequest;
import com.caijiale.paipai.base.page.PageResult;
import com.caijiale.paipai.user.domain.entity.User;
import com.caijiale.paipai.user.domain.request.UserRegisterReq;
import com.caijiale.paipai.user.domain.request.UserReq;
import com.caijiale.paipai.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    @Spy
    private UserServiceImpl userServiceImplUnderTest;

    @Test
    void testQueryById() {
        // Setup
        final User expectedResult = User.builder()
                .id(0L)
                .username("username")
                .password("password")
                .deleted(0)
                .userRole("userRole")
                .loginType(0)
                .openId("openId")
                .salt("salt")
                .build();

        // Run the test
        final User result = userServiceImplUnderTest.queryById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testPaginQuery() {
        // Setup
        final UserReq userReq = new UserReq();
        userReq.setPageRequest(new PageRequest());
        userReq.setUsername("username");
        userReq.setDeleted("deleted");
        userReq.setUserRole("userRole");
        userReq.setLoginType("loginType");
        userReq.setOpenId("openId");
        userReq.setSalt("salt");

        // Run the test
        final PageResult result = userServiceImplUnderTest.paginQuery(userReq);

        // Verify the results
    }

    @Test
    void testInsert() {
        // Setup
        final User user = User.builder()
                .id(0L)
                .username("username")
                .password("password")
                .deleted(0)
                .userRole("userRole")
                .loginType(0)
                .openId("openId")
                .salt("salt")
                .build();
        final User expectedResult = User.builder()
                .id(0L)
                .username("username")
                .password("password")
                .deleted(0)
                .userRole("userRole")
                .loginType(0)
                .openId("openId")
                .salt("salt")
                .build();

        // Run the test
        final User result = userServiceImplUnderTest.insert(user);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
        verify(userMapper).insert(User.builder()
                .id(0L)
                .username("username")
                .password("password")
                .deleted(0)
                .userRole("userRole")
                .loginType(0)
                .openId("openId")
                .salt("salt")
                .build());
    }

    @Test
    void testUpdate() {
        // Setup
        final User user = User.builder()
                .id(0L)
                .username("username")
                .password("password")
                .deleted(0)
                .userRole("userRole")
                .loginType(0)
                .openId("openId")
                .salt("salt")
                .build();
        final User expectedResult = User.builder()
                .id(0L)
                .username("username")
                .password("password")
                .deleted(0)
                .userRole("userRole")
                .loginType(0)
                .openId("openId")
                .salt("salt")
                .build();

        // Run the test
        final User result = userServiceImplUnderTest.update(user);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDeleteById() {
        // Setup
        when(userMapper.deleteById(0L)).thenReturn(0);

        // Run the test
        final boolean result = userServiceImplUnderTest.deleteById(0L);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testRegister() {
        // Setup
        final UserRegisterReq userRegisterReq = new UserRegisterReq();
        userRegisterReq.setUsername("username");
        userRegisterReq.setPassword("password");


        when(userMapper.selectCount(any(LambdaQueryWrapper.class))).thenReturn(0L);
        when(userMapper.insert(any(User.class))).thenReturn(0);

        try {
            boolean result = userServiceImplUnderTest.register(userRegisterReq);
            assertTrue(result);
        } catch (Exception e) {
            fail("testRegister failed", e);
        }
    }
}
