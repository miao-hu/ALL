from selenium import webdriver
import time
import os

driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/QQ下载的/selenium2html/selenium2html/alert.html")
driver.get(file_path)   # 打开这个文件
time.sleep(3)

driver.find_element_by_id("tooltip").click()
time.sleep(3)

alert = driver.switch_to.alert         # 得到alert()框
print(alert.text)                      # 打印alert()框的文本内容
alert.accept()                         # 确认alert()框

time.sleep(2)
driver.quit()
