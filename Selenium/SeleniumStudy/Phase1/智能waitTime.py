#coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包

driver = webdriver.Chrome()       # 创建 chrome 对象
driver.get("https://www.csdn.net/")

driver.implicitly_wait(5)         # 智能等待5秒
driver.find_element_by_link_text("学院").click()
driver.quit()                     # 关闭 chrome 对象
