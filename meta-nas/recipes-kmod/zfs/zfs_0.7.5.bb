SUMMARY = "Native OpenZFS filesystem kernel modules for Linux"
LICENSE = "CDDL-1.0"
LIC_FILES_CHKSUM = "file://OPENSOLARIS.LICENSE;md5=7087caaf1dc8a2856585619f4a787faa"

SRC_URI = "git://github.com/zfsonlinux/zfs;protocol=http;branch=zfs-0.7-release \
	file://notests.patch"

PV = "${SRCPV}"
S = "${WORKDIR}/git"
SRCREV = "zfs-0.7.5"
inherit autotools
DEPENDS = "zlib util-linux spl-module attr"
RDEPENDS_${PN} = "zfs-module spl-module"
EXTRA_OECONF = " --with-config=user --with-linux=${STAGING_KERNEL_DIR} --with-linux-obj=${STAGING_KERNEL_BUILDDIR} --with-spl=${STAGING_EXECPREFIXDIR}/src/spl-0.7.5 --disable-static"

FILES_${PN} = "${base_sbindir} ${sbindir}/zfs ${sbindir}/zpool ${sbindir}/zdb  ${libdir}/*.so.* ${base_libdir}/udev"

do_install_append () {
	rm -rf ${D}/etc
	rm -rf ${D}/usr/libexec
	rm -rf ${D}/usr/share
	rm -rf ${D}/usr/src
	rm -rf ${D}/usr/lib/dracut
	rm -rf ${D}/usr/lib/modules-load.d
	rm -rf ${D}/usr/lib/systemd
	rm -rf ${D}/usr/bin
	rm -f ${D}/usr/sbin/ztest
	rm -f ${D}/usr/sbin/zpios
	rm -f ${D}/usr/sbin/zstreamdump
	rm -f ${D}/usr/sbin/zed
	rm -f ${D}/usr/sbin/zinject
	rm -f ${D}/usr/sbin/zhack
	rm -f ${D}/usr/sbin/fsck.zfs
}
