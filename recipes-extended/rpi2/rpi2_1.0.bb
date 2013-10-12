DESCRIPTION = "owserver configuration for RPI2"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/owserver;md5=01a9472842297a884c6c1b01fe0da880"
RDEPENDS_${PN} = "owserver owfs"
PR = "r0"

SRC_URI = "file://owserver"


do_install () {
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/owserver ${D}${sysconfdir}/default/
}
