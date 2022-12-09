package hello.springmvc.basic.requetmapping;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt( request.getParameter("age"));

        log.info("uesrname {}, age = {}",username,age );

        response.getWriter().write("ok");

    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("uesrname") String username,
            @RequestParam("age") int age
    ){
        log.info("uesrname {}, age = {}",username,age );
        return "ok" ;
        // 뷰 리졸버가 조회할 뷰 이름이 아니라
        // 리스폰스 바디에 바로 데이터를 반환 하려면
        // 1. @RESTCONTROLLER 어노테이션을 클래스에 선언
        // 2. @RESPONSEBODY 를 해당 메서드에 선언
    }




    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("uesrname {}, age = {}",username,age );
        return "ok" ;
        // 뷰 리졸버가 조회할 뷰 이름이 아니라
        // 리스폰스 바디에 바로 데이터를 반환 하려면
        // 1. @RESTCONTROLLER 어노테이션을 클래스에 선언
        // 2. @RESPONSEBODY 를 해당 메서드에 선언
    }







    /*
    요청 파라미터 이름과 메서드 파라미터 이름이 일치시키면
    단순 타입에 대하여 @RequestParam도 생략할수 있다.
     */

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age
    ){
        log.info("userrname {}, age = {}",username,age );
        return "ok" ;

    }


    /*
    기
    필수 파라메터를 설정 - 기본값은 필수다

    요청에 필수 파라메터가 없으면 에러를 발생
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age
    ){   //기본 자료형들 int = null (X)  Integer = null (가능)
        //int parameter 'age' is present but cannot be translated into a null value
        log.info("userrname {}, age = {}",username,age );
        return "ok" ;

    }


    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true,defaultValue = "def") String username,
            @RequestParam(required = false,defaultValue = "-1") Integer age
    ){   //기본 자료형들 int = null (X)  Integer = null (가능)
        //int parameter 'age' is present but cannot be translated into a null value
        log.info("userrname {}, age = {}",username,age );
        return "ok" ;

    }


    @ResponseBody
    @RequestMapping("/request-param-param-map")
    public String requestParamParamMap(@RequestParam Map<String, Objects> paramMap){   //기본 자료형들 int = null (X)  Integer = null (가능)
        //int parameter 'age' is present but cannot be translated into a null value
        log.info("userrname {}, age = {}",paramMap.get("username"),paramMap.get("age") );
        return "ok" ;

    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttirbuteV1(@ModelAttribute HelloData helloData){   //기본 자료형들 int = null (X)  Integer = null (가능)
        //int parameter 'age' is present but cannot be translated into a null value
        log.info("hellodata = {}",helloData );
        return "ok" ;

    }


    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttirbuteV2( HelloData helloData){   //기본 자료형들 int = null (X)  Integer = null (가능)
        //int parameter 'age' is present but cannot be translated into a null value
        log.info("hellodata = {}",helloData );
        return "ok" ;

    }

}
