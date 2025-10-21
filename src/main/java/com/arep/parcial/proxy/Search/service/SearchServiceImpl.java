package com.arep.parcial.proxy.Search.service;

import com.arep.parcial.proxy.Search.Response;
import com.arep.parcial.proxy.Search.service.port.SearchService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public Response getLinear(String list, int value){
        int[] nums = Arrays.stream(list.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int out = -1;

        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == value){
                out = i;
                break;
            }
        }

        return new Response("linearsearch" , list , value , out);
    }


    @Override
    public Response getBYnary(String list, int value){
        int[] nums = Arrays.stream(list.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int out = binarySearchFunction(nums,value,0 , nums.length - 1);

        return new Response("binarysearch",list,value,out);
    }

    private int binarySearchFunction(int[] nums , int value , int inicio , int fin){
        if(inicio > fin){return -1;}

        int medio = inicio + (fin - inicio) / 2;

        if (nums[medio] == value) {
            return medio;
        }

        if (nums[medio] < value ) {
            return binarySearchFunction(nums ,value ,medio + 1 , fin);
        }

        if (nums[medio] > value ) {
            return binarySearchFunction(nums ,value ,inicio,medio - 1 );
        }
        return -1;
    }
}
