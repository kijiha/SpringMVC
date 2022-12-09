package hello.springmvc.basic.requetmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "OK";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String userId -> @PathVariable userId
     */

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("PathVariable user id = {}", userId);
        return "OK";
    }

    /**
     * PathVariable 사용 다중
     */

    @GetMapping("/mapping/{userId}/orders/{orderId}")
    public String mappingPathValMulty(@PathVariable String userId
            , @PathVariable("orderId") String orderId) {
        log.info("PathVariable user id = {}, orderId = {}", userId, orderId);
        return "OK";
    }


    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     * <p>
     * 요청 데이터의 파라메터에 대한 조건문을 추가하여 조건문을 통과해야 로직이 실행된다.
     * 요청 메시지에 모드이름의 파라메터가 디버그일때 서비스 로직이 실행
     */

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParm() {
        log.info("mappingParam");
        return "OK";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */

    @PostMapping(value = "/mapping-consume", consumes = MediaType.TEXT_HTML_VALUE ,produces ="text/html" )
    public String mappingConsume(){
        log.info("mappingConsumeAndProduce");
        return "ok";
    }
}
