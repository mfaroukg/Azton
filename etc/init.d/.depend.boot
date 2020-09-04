TARGETS = console-setup alsa-utils ebtables mountkernfs.sh resolvconf ufw pppd-dns screen-cleanup plymouth-log x11-common apparmor hostname.sh udev mountdevsubfs.sh procps hwclock.sh checkroot.sh checkfs.sh urandom checkroot-bootclean.sh kmod networking mountnfs-bootclean.sh mountnfs.sh bootmisc.sh mountall.sh mountall-bootclean.sh
INTERACTIVE = console-setup udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
procps: mountkernfs.sh udev
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
checkfs.sh: checkroot.sh
urandom: hwclock.sh
checkroot-bootclean.sh: checkroot.sh
kmod: checkroot.sh
networking: resolvconf mountkernfs.sh urandom procps
mountnfs-bootclean.sh: mountnfs.sh
mountnfs.sh: networking
bootmisc.sh: mountnfs-bootclean.sh udev mountall-bootclean.sh checkroot-bootclean.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
mountall-bootclean.sh: mountall.sh
