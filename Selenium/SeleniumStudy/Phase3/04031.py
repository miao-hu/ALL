from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
time.sleep(3)

# driver.find_element_by_id("kw").send_keys("腾讯2020春招")
# driver.find_element_by_id("su").click()

# driver.find_element_by_name("wd").send_keys("腾讯2020春招")
# driver.find_element_by_id("su").click()

driver.find_element_by_class_name("s_ipt").send_keys("腾讯2020春招")
driver.find_element_by_class_name("bg s_btn btn_h btnhover").click()
# 报错: Unable to locate element
# 原因：定位不到 bg s_btn btn_h btnhover 对应的这个元素，原因该 class_name 对应的（bg s_btn btn_h btnhover）出现了多次
# 最终出现界面是因为百度有缓存智能功能

time.sleep(4)
driver.quit()
