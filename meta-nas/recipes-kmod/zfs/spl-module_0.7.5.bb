SUMMARY = "The Solaris Porting Layer is a Linux kernel module which provides many of the Solaris kernel APIs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRC_URI = "git://github.com/zfsonlinux/spl;protocol=http;branch=spl-0.7-release"

PV = "${SRCPV}"
S = "${WORKDIR}/git"
SRCREV = "spl-0.7.5"
inherit module autotools
EXTRA_OECONF = " --with-config=kernel --with-linux=${STAGING_KERNEL_DIR} --with-linux-obj=${STAGING_KERNEL_BUILDDIR}"
SYSROOT_DIRS = "/usr/src"
FILES_${PN}-dev = "/usr"
