#!/bin/sh

set -xe

usage() {
	while read -r line
	do printf '%b\n' "$line"
	done <<-USAGE
		./${0##*/} -h | --help
		./${0##*/} -r | --rebuild
		./${0##*/} -N
		./${0##*/} -tN

		options:
		\t-h  - display this message
		\t-r  - force a rebuild of the jar
		\t-N  - where N is a number between 1 and 25 (inclusive)
		\t      Run day N of AdventOfCode
		\t-tN - Run the sample input for day N
	USAGE
}

case $1 in
	-r | --rebuild )
		rm -f aoc2021.jar || :
		shift
	;;
	-h | --help )
		set +x
		usage
		exit 0
	;;
esac

if [ ! -e aoc2021.jar ]
then
	rm src/*.class || :
	javac src/*.java

	classes=""
	for i in src/*.class
	do classes="$classes-C src ${i#src/} "
	done

	# shellcheck disable=SC2086
	jar -cfe aoc2021.jar Main ${classes}
fi

java -jar aoc2021.jar "$@"
