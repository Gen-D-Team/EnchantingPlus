move:
	cls
	mvn clean -f "d:\Dev4future\MinecraftPluginWorkSpace\EnchantingPlus\enchantplus\pom.xml"
	mvn package -f "d:\Dev4future\MinecraftPluginWorkSpace\EnchantingPlus\enchantplus\pom.xml"
	del "D:\MinecraftServer\Test\pluginsenchantplus-devbuild-0.2.jar"
	move "D:\Dev4future\MinecraftPluginWorkSpace\EnchantingPlus\enchantplus\target\enchantplus-devbuild-0.2.jar" "D:\MinecraftServer\Test\plugins"
	cd D:\MinecraftServer\Test && start D:\MinecraftServer\Test\start.bat