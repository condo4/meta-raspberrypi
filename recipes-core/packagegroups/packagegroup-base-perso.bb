DESCRIPTION = "Tasks for Perso RPI Base Filesystem"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = "\
	rpi2 \
	owshell \
	owpython \
	python-mysqldb \
	python-dateutil \
	xauth \
	lsof \
	ntpdate \
	i2c-tools \
	owdatalogger \
"
