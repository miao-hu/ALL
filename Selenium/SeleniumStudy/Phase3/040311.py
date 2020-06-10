from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
time.sleep(2)
driver.maximize_window()   # 浏览器的最大化

driver.find_element_by_link_text("hao123").click()
time.sleep(2)

title = driver.title
print(title)
url = driver.current_url
print(url)

driver.forward()        # 返回到上一界面
time.sleep(3)

title = driver.title
print(title)
url = driver.current_url
print(url)

driver.quit()
