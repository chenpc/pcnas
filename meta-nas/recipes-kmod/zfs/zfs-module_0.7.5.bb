SUMMARY = "Native OpenZFS filesystem kernel modules for Linux"
LICENSE = "CDDL-1.0"
LIC_FILES_CHKSUM = "file://OPENSOLARIS.LICENSE;md5=7087caaf1dc8a2856585619f4a787faa"

SRC_URI = "git://github.com/zfsonlinux/zfs;protocol=http;branch=zfs-0.7-release \
	file://notests.patch"

PV = "${SRCPV}"
S = "${WORKDIR}/git"
SRCREV = "zfs-0.7.5"
inherit module autotools
DEPENDS = "zlib util-linux spl-module attr"
#RDEPENDS_${PN} = "spl-module"
EXTRA_OECONF = " --with-config=kernel --with-linux=${STAGING_KERNEL_DIR} --with-linux-obj=${STAGING_KERNEL_BUILDDIR} --with-spl=${STAGING_EXECPREFIXDIR}/src/spl-0.7.5 --disable-static"

FILES_${PN}-dev = "/usr"
