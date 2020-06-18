from selenium import webdriver
import time
import os

driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/QQ下载的/selenium2html/selenium2html/send.html")
driver.get(file_path)   # 打开这个文件
time.sleep(3)

driver.find_element_by_xpath("/html/body/input").click()
time.sleep(3)

# 弹出一个警告框
alert = driver.switch_to.alert    # 拿到警告框的句柄
alert.send_keys("123456789")      # 往警告框输入字符
time.sleep(3)
print(alert.text)                 # 打印警告框的内容
alert.accept()                    # 确定警告框

time.sleep(2)
driver.quit()
