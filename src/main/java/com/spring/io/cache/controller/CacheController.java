package com.spring.io.cache.controller;

import com.spring.io.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
 spring-boot-starter-cache 라이브러리를 불러왔으면 @EnableCaching으로 해당 어플리케이션에서 캐시를 사용할 것임을 알린다.
 그 후 캐시가 적용될 메서드에는 @Cacheable(value="XXX")를 적용한다.
 그러면 해당 메서드가 최초 1회 이후 호출될때마다 메서드의 파라미터가 같은 값이면 메서드를 호출하지 않고 결과값을 캐시에서 꺼내 리턴해준다.
 value 값은 캐시 아이디라고 보면된다.
 데이터가 업데이트되어 기존 캐시를 삭제해야할 필요가 있을 때 @CacheEvict(value="XXX")를 적용하게 되는데, 이럴 때 value 값이 동일한 캐시를 지워버리기 때문에
 value는 아이디라고 생각하면 된다.
 참고로 default로 메서드의 파라미터를 캐시 값으로 구성한다.
 즉, 같은 메서드가 불리더라도 파라미터가 다르면 다른 캐시를 생성하는 것이다. -> 파라미터가 같으면 같은 캐시?
 */
@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;

    @GetMapping("/cache")
    public List<Integer> list( ) {
        System.out.println("aaa");
        return cacheService.findList( );
    }

    @GetMapping("/refresh")
    public List<Integer> refresh_cache( ) {
        return cacheService.refresh_cache();
    }

    @GetMapping("/remove")
    public void remove_cache( ) {
        cacheService.remove_cache( );
    }
}
