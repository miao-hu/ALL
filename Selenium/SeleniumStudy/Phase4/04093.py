from selenium import webdriver
import time
import os

driver = webdriver.Chrome()
file_path = 'file:///'+os.path.abspath("E:/QQ下载的/selenium2html/selenium2html/alert.html")
driver.get(file_path)         # 打开这个文件
time.sleep(3)

driver.find_element_by_id("tooltip").click()
time.sleep(3)

alert = driver.switch_to.alert        # 拿到警告框的句柄
print(alert.text)                     # 输出警告框的内容
alert.dismiss()                       # 关掉警告框

time.sleep(2)
driver.quit()




