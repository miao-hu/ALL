# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包
import os

driver = webdriver.Chrome()       # 创建 chrome 对象
file_path = 'file:///' + os.path.abspath("upload.html")
driver.get(file_path)
time.sleep(2)

driver.find_element_by_name("file").send_keys("E:\\789456.jpg")
time.sleep(3)

driver.quit()                     # 关闭 chrome 对象
