@echo @echo off
TITLE BukkitPE server software for Minecraft: Pocket Edition
cd /d %~dp0

if exist bin\php\php.exe (
	set PHPRC=""
	set PHP_BINARY=bin\php\php.exe
) else (
	set PHP_BINARY=php
)

if exist BukkitPE.phar (
	set BukkitPE_FILE=BukkitPE.phar
) else (
	if exist src\BukkitPE\BukkitPE.php (
		set BukkitPE_FILE=src\BukkitPE\BukkitPE.php
	) else (
		echo "Couldn't find a valid BukkitPE installation"
		pause
		exit 1
	)
)

REM if exist bin\php\php_wxwidgets.dll (
REM 	%PHP_BINARY% %BukkitPE_FILE% --enable-gui %*
REM ) else (
	if exist bin\mintty.exe (
		start "" bin\mintty.exe -o Columns=88 -o Rows=32 -o AllowBlinking=0 -o FontQuality=3 -o Font="DejaVu Sans Mono" -o FontHeight=10 -o CursorType=0 -o CursorBlinks=1 -h error -t "BukkitPE server software" -i bin/pocketmine.ico -w max %PHP_BINARY% %BukkitPE_FILE% --enable-ansi %*
	) else (
		%PHP_BINARY% -c bin\php %BukkitPE_FILE% %*
	)
REM )
