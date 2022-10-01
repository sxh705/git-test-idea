package others.javaSE.junit;

public class UserServise {
    public String loginName(String loginName, String passWord) {
        if ("admin".equals(loginName) && "123456".equals(passWord)) {
            return "登录成功";
        } else {
            return "登录失败";
        }
    }

    public void selectNames() {
        System.out.println(10 / 0);
        System.out.println("查询成功");
    }

}
