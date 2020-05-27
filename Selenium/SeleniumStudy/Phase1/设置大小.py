# coding : utf-8
from selenium import webdriver    # 导入 webdriver ,相当于加载了 webdriver 里面所有的方法
import time                       # 导入 time 包

driver = webdriver.Chrome()       # 创建 chrome 对象
driver.get("https://www.csdn.net/")

time.sleep(3)                     # 网页打开后等待停止3秒
driver.maximize_window()          # 全屏显示

driver.refresh()                  # 刷新页面
time.sleep(5)                     # 目的是为了查看效果
driver.quit()                     # 关闭 chrome 对象
