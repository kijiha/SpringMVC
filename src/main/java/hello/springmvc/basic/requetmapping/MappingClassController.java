package hello.springmvc.basic.requetmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

/*
    회원 목록 조회: GET /mapping/users
    회원 등록: POST /mapping/users
    회원 조회: GET /mapping/users/id1
    회원 수정: PATCH /mapping/users/id1
    회원 삭제: DELETE /mapping/users/id1

    리소스를 계층으로 식별하고 있다

    */

    @GetMapping
    public String users() {
        return "get users";
    }


    @PostMapping
    public String addUser() {
        return "post users";
    }


    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "find user "+userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update user "+userId;
    }


    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete user"+userId;
    }
}
