from selenium import webdriver    # 导入浏览器驱动
import unittest                   # 导入 unittest 测试框架
import time

# 该类继承自 unittest.TestCase 类
class imageTest(unittest.TestCase):
    # 初始化工作（获得浏览器驱动，打开被测试系统,self 是该类的一个实例）
    def setUp(self):
        self.driver=webdriver.Firefox()
        self.driver.get("http://127.0.0.1:8080/java_image_server/index.html")
        self.driver.maximize_window()
        time.sleep(3)

    # 清理工作
    def tearDown(self):
        self.driver.quit()

    @unittest.skip("skipping")
    def test_upload(self):
        self.driver.find_element_by_name("filename").send_keys("C:\\Users\\小露儿\\Pictures\\图片服务器\\128.jpg")
        time.sleep(3)
        self.driver.find_element_by_xpath("//*[@id='blog-collapse']/form/div[2]/input").click()
        time.sleep(3)

    def test_delete(self):
        self.driver.find_element_by_xpath("//*[@id='container']/div[1]/button").click()
        time.sleep(5)      # 此处必须等待，因为有可能alert()框可能没有弹出来，就会出现找不到alert()框的情况
        q=self.driver.switch_to.alert
        q.accept()
        time.sleep(3)

if __name__=="__main__":
    unittest.main()




