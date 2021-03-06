# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()       # 创建 chrome 对象
driver.get("https://www.baidu.com/")
time.sleep(2)                     # 网页打开后等待停止2秒

shuru = driver.find_element_by_id("kw")
shuru.send_keys("你好世界")
time.sleep(2)

shuru.send_keys(Keys.CONTROL,'a') # 全选
time.sleep(2)

shuru.send_keys(Keys.BACKSPACE)   # 剪切
time.sleep(2)

shuru.send_keys("哈哈哈")
time.sleep(2)

driver.quit()                     # 关闭 chrome 对象
