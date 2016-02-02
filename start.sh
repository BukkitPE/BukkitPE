#!/bin/bash
DIR="$(cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd)"
cd "$DIR"

DO_LOOP="yes"

while getopts "p:f:l" OPTION 2> /dev/null; do
	case ${OPTION} in
		p)
			PHP_BINARY="$OPTARG"
			;;
		f)
			BukkitPE_FILE="$OPTARG"
			;;
		l)
			DO_LOOP="yes"
			;;
		\?)
			break
			;;
	esac
done

if [ "$PHP_BINARY" == "" ]; then
	if [ -f ./bin/php5/bin/php ]; then
		export PHPRC=""
		PHP_BINARY="./bin/php5/bin/php"
	elif [ type php 2>/dev/null ]; then
		PHP_BINARY=$(type -p php)
	else
		echo "Couldn't find a working PHP binary, please use the installer provided at BukkitPE.net"
		exit 1
	fi
fi

if [ "$BukkitPE_FILE" == "" ]; then
	if [ -f ./BukkitPE.phar ]; then
		BukkitPE_FILE="./BukkitPE.phar"
	elif [ -f ./src/BukkitPE/BukkitPE.php ]; then
		BukkitPE_FILE="./src/BukkitPE/BukkitPE.php"
	else
		echo "Couldn't find a valid BukkitPE installation"
		exit 1
	fi
fi

LOOPS=0

set +e
while [ "$LOOPS" -eq 0 ] || [ "$DO_LOOP" == "yes" ]; do
	if [ "$DO_LOOP" == "yes" ]; then
		"$PHP_BINARY" "$BukkitPE_FILE" $@
	else
		exec "$PHP_BINARY" "$BukkitPE_FILE" $@
	fi
	((LOOPS++))
done

if [ ${LOOPS} -gt 1 ]; then
	echo "Restarted $LOOPS times"
fi
