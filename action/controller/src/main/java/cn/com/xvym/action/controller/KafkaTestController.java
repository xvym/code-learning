package cn.com.xvym.action.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigDecimal.ROUND_CEILING;
import static java.math.RoundingMode.HALF_UP;

/**
 * @Author: Xv
 * @Date: 2021/8/22 13:02
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/api/kafka")
public class KafkaTestController {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping("/hello-kafka")
    public String helloKafka(String input) {
        kafkaTemplate.send("test_topic", input);
        return "success";
    }

    @KafkaListener(id = "webGroup", topics = "test_topic")
    public void listen(String input) {
        log.info(input);
    }


    public static void main(String[] args) {
        int[][] nums = {{4,5},{7,8}};
        System.out.println(interchangeableRectangles(nums));
    }

    public static long interchangeableRectangles(int[][] rectangles) {
        Integer res = 0;
        Map<BigDecimal, Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            BigDecimal a = BigDecimal.valueOf((double) rectangle[1]);
            BigDecimal b = BigDecimal.valueOf((double) rectangle[0]);
            BigDecimal divide = a.divide(b, 100, HALF_UP);
            if (map.containsKey(divide)) {
                int count = map.get(divide);
                res += count;
                count++;
                map.put(divide, count);
            } else {
                map.put(divide, 1);
            }
        }
        return res;
    }

}
