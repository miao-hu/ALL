# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包

driver = webdriver.Chrome()       # 创建 chrome 对象
driver.get("http://localhost:63342/0403/SeleniumStudy/test.html?_ijt=dtl3gv2rnjguvu3p26cv7g8h89")
time.sleep(2)                     # 网页打开后等待停止2秒

# 复制的xpath为    /html/body/input[1]       中间填充1,2,3
list = driver.find_elements_by_xpath("/html/body/input")
print("总共有多少个复选框:",len(list))
for e in list:
    e.click()     # 点击每一个复选框

time.sleep(5)

driver.find_element_by_xpath("/html/body/input[2]").click()
time.sleep(5)
driver.quit()                     # 关闭 chrome 对象
