DESCRIPTION = "boot image with UEFI shell and tools"

# For this image recipe, only the wic format with a
# single vfat partition makes sense.
IMAGE_FSTYPES_forcevariable = 'wic'

WKS_FILE = "ovmf/ovmf-shell-image.wks"
inherit image

# We want a minimal image with just ovmf-shell-efi unpacked in it. We
# avoid installing unnecessary stuff as much as possible, but some
# things still get through and need to be removed.
PACKAGE_INSTALL = "ovmf-shell-efi"
LINGUAS_INSTALL = ""
do_image () {
    rm -rf `ls -d ${IMAGE_ROOTFS}/* | grep -v efi`
}
