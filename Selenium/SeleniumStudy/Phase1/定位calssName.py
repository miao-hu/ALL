# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包

driver = webdriver.Chrome()       # 创建 chrome 对象
driver.get("https://mail.qqqq.com/")
# 假设这个一个登录界面，账号，密码，再次输入密码框的class_name都相同，且为class="inputstyle"
time.sleep(2)                     # 网页打开后等待停止2秒

# 因为三个输入框的class_name都相同，所以定位就会出现错误，可以这样改:
driver.find_element_by_class_name("inputstyle").send_keys("123456")           # 在账号输入框输入123456
driver.find_elements_by_class_name("inputstyle")[1].send_keys("123456789")    # 在密码输入框输入123456789
driver.find_elements_by_class_name("inputstyle")[2].send_keys("123456789")    # 在再次输入密码输入框输入123456789
time.sleep(5)
# 需要明白的是element方法返回一个元素，elements方法返回一个List列表

driver.quit()                     # 关闭 chrome 对象
