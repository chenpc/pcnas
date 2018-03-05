FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://smb.patch \
            file://passdb.tdb"

do_install_append() {
    install -d ${D}/var/lib/samba/private
    install -m 0600 ${WORKDIR}/passdb.tdb ${D}/var/lib/samba/private
}
