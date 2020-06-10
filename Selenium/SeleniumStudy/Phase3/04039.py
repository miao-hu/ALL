from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")

driver.maximize_window()   # 浏览器的最大化

driver.find_element_by_link_text("hao123").click()
time.sleep(3)
driver.set_window_size(400, 800)   # 让浏览器固定大小显示
time.sleep(3)

title = driver.title
print(title)

url = driver.current_url
print(url)

time.sleep(3)
driver.quit()
