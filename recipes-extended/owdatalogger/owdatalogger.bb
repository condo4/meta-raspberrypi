DESCRIPTION = "OWFS data logger"
SECTION = "base"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=2ff2547d705d9907f66a7620da7a8991"
RDEPENDS_${PN} = "initscripts\
	mysql5 \
	libowcapi \
"
PR = "r1"

SRC_URI = "git://github.com/condo4/owdatalogger.git;protocol=git"
SRCREV = "d63e4bfbc8834027a0e7a5080834afaafbed109e"

inherit update-rc.d distutils-base cmake pkgconfig

S = "${WORKDIR}/git/src"


do_install () {
	install -d ${D}${sysconfdir}/
	install -m 0755 ${WORKDIR}/git/owdatalogger.cfg ${D}${sysconfdir}/
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/git/owdatalogger.init ${D}${sysconfdir}/init.d/owdatalogger
	
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/git/src/owdatalogger ${D}${sbindir}/
	
	install -d ${D}/www/pages
	install -m 0755 ${WORKDIR}/git/src/owdatalogger.py ${D}/www/pages/
	install -m 0755 ${WORKDIR}/git/src/website/index.py ${D}/www/pages/
	
	install -d ${D}${datadir}
	install -m 0755 ${WORKDIR}/git/owdatalogger.sql ${D}${datadir}/
}

FILES_${PN} += "${sysconfdir}/init.d/owdatalogger"
FILES_${PN} += "${sysconfdir}/owdatalogger.cfg"
FILES_${PN} += "${sbindir}/owdatalogger"
FILES_${PN} += "${datadir}/owdatalogger.sql"
FILES_${PN} += "/www/pages"

INITSCRIPT_PACKAGES = "owdatalogger"
INITSCRIPT_NAME = "owdatalogger"
INITSCRIPT_PARAMS = "start 80 5 . stop 80 0 6 1 ."
