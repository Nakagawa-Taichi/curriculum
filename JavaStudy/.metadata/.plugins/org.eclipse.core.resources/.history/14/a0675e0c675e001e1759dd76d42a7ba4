package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private UserService userService;

  /**
   * ユーザー情報一覧画面を表示
   * @param  model Model
   * @return  ユーザー情報一覧画面のHTML
   */
  @GetMapping("/user/list")
 public String displayList(Model model) {
  List<UserEntity> userlist = userService.searchAll();
    model.addAttribute("userlist",userlist) ;
    return "user/list";
 }

 /**
 * ユーザー新規登録画面を表示
 * @param  model Model
 * @return  ユーザー情報一覧画面
 */
   @GetMapping("/user/add")
 public String displayAdd(Model model) {
     //一行追加
       model.addAttribute("formObject", new UserRequest());
    return "user/add";
 }
 
 /**
  * ユーザー新規登録
  * @param  userRequest リクエストデータ
  * @param  model Model
  * @return  ユーザー情報一覧画面
  */

   @PostMapping("/user/create")
   public String create(@ModelAttribute @Valid UserRequest userRequest, BindingResult result, Model model) {
       // 入力判定入れること
       if (result.hasErrors()) {
           // 入力チェックエラーの場合3行実装
           List<String> errorList = new ArrayList<String>();
           for (ObjectError error : result.getAllErrors()) {
               errorList.add(error.getDefaultMessage());
           }
           model.addAttribute("formObject", new UserRequest());
           model.addAttribute("validationError", errorList);
           return "user/add";
       }

       // ユーザー情報の登録2行実装
       userService.create(userRequest);

       return "redirect:/user/list";
   }
 
 
 /**
 * ユーザー情報詳細画面を表示
 * @param  id 表示するユーザーID
 * @param  model Model
 * @return  ユーザー情報詳細画面
 */
 @GetMapping("/user/{id}")
 public String displayView(@PathVariable Integer id, Model model) {
   UserEntity user = userService.findById(id);
   model.addAttribute("formObject", user);
 return "user/view";
 }

/**
 * ユーザー編集画面を表示
 * @param  id 表示するユーザーID
 * @param  model Model
 * @return  ユーザー編集画面
 */
@GetMapping("/user/{id}/edit")
public String displayEdit(@PathVariable  Integer id, Model model) {
 UserEntity user = userService.findById(id);
 UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
//実装5行
    userUpdateRequest.setId(user.getId());
    userUpdateRequest.setName(user.getName());
    userUpdateRequest.setAddress(user.getAddress());
    userUpdateRequest.setPhone(user.getPhone());

    model.addAttribute("formObject", userUpdateRequest);

  return "user/edit";
}
/**
 * ユーザー更新
 * @param  userRequest リクエストデータ
 * @param  model Model
 * @return  ユーザー情報詳細画面
 */
@PostMapping("/user/update")
public String update(@ModelAttribute @Valid UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
  if (result.hasErrors()) {
    List<String> errorList = new ArrayList<String>();
    for (ObjectError error : result.getAllErrors()) {
      errorList.add(error.getDefaultMessage());
    }
    model.addAttribute("validationError", errorList);
    return "user/edit";
  }
  // ユーザー情報の更新
  userService.update(userUpdateRequest);
  return String.format("redirect:/user/%d", userUpdateRequest.getId());
  }
  
/**
 * ユーザー情報削除
 * @param  id 表示するユーザーID
 * @param  model Model
 * @return  ユーザー情報詳細画面
 */
@GetMapping("/user/{id}/delete")
public String delete(@PathVariable Integer id, Model model) {
 // ユーザー情報の削除実装2行
 userService.delete(id);
    return "redirect:/user/list";
 }
}
