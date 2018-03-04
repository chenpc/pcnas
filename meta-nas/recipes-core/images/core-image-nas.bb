SUMMARY = "NAS Firmware Image"
IMAGE_FEATURES = "empty-root-password allow-empty-password"
IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} zfs 9p lsof strace openssh-sshd openssh-keygen useradd-admin fio"
IMAGE_INSTALL += "tmux samba networkmanager"
IMAGE_INSTALL += "kernel-module-8021q kernel-module-bonding python3-nas"
IMAGE_INSTALL += "kernel-module-iscsi-target-mod kernel-module-target-core-mod kernel-module-target-core-iblock kernel-module-target-core-file kernel-module-target-core-pscsi"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "409600"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
BOOTIMG_EXTRA_SPACE = "${IMAGE_ROOTFS_SIZE} + 65536"
SYSLINUX_DEFAULT_CONSOLE = "console=tty1 console=ttyS0,115200"
AUTO_SYSLINUXMENU = "0"
