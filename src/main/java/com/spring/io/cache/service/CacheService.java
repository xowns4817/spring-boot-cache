package com.spring.io.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CacheService {

    // 이 부분은 최초 1번 실행 이 부분의 캐시값을 바꾸려면 CachePut에서 바꿔야함.
    @Cacheable(value="List")
    public List<Integer> findList ( ) {
        List<Integer> list = new ArrayList<Integer>();
        System.out.println("bbb");
        Random random = new Random();
        int idx = random.nextInt(100);
        for(int i=0; i<100; i++)  {
            list.add(i);
        }

        System.out.println("ccc");
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return list;
    }

    // 게시물 업데이트가 일어날때 호출해주면 됨. refrsh Cache
    @CachePut(value="List")
    public List<Integer> refresh_cache( ) {
        System.out.println("refresh Cache!!");
        List<Integer> list = new ArrayList<Integer>();
        System.out.println("bbb");
        Random random = new Random();
        int idx = random.nextInt(100);
        for(int i=0; i<idx; i++)  {
            list.add(i);
        }

        System.out.println("ccc");
        try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return list;
    }

    @CacheEvict(value="List")
    public void remove_cache() {
        System.out.println("remove Cache!!");
    }
}
