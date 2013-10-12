
# Include modules in rootfs
IMAGE_INSTALL += " \
	packagegroup-core-boot \
	packagegroup-core-basic \
	${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL} \
	kernel-modules \
	packagegroup-base-perso \
	"

#CORE_IMAGE_EXTRA_INSTALL = " packagegroup-base-perso "

EXTRA_IMAGE_FEATURES += "package-management"

IMAGE_FEATURES += "ssh-server-openssh splash package-management"


LICENSE = "MIT"

inherit core-image
