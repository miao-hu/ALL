//存储用户信息

public class User {
    String name;    //姓名
    String mobilePhone;//手机号码
    String officePhone;//办公室号码

    public User(String name, String mobilePhone, String officePhone) {
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.officePhone = officePhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", officePhone='" + officePhone + '\'' +
                '}';
    }
}
