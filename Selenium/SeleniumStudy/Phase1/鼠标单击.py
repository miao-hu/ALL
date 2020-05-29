# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包

driver = webdriver.Chrome()       # 创建 chrome 对象
driver.get("https://www.baidu.com/")
time.sleep(2)                     # 网页打开后等待停止2秒

danji = driver.find_element_by_link_text("hao123")     # 查找页面内容为hao123的句柄
danji.click()                     # 鼠标单击
time.sleep(3)

driver.quit()                     # 关闭 chrome 对象
