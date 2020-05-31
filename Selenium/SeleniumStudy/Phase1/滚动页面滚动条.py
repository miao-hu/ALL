# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包

driver = webdriver.Chrome()       # 创建 chrome 对象
driver.get("https://www.baidu.com/")
time.sleep(2)                     # 网页打开后等待停止2秒

driver.find_element_by_name("wd").send_keys("你好世界")    # 在输入框输入你好世界
driver.find_element_by_id("su").click()
time.sleep(3)

# 将页面滚动条拖到底部
js = "var q=document.documentElement.scrollTop=100000"
driver.execute_script(js)
time.sleep(3)

# 将滚动条移动到页面的顶部
js = "var q=document.documentElement.scrollTop=0"
driver.execute_script(js)
time.sleep(3)

driver.quit()                     # 关闭 chrome 对象
